package Object;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloneUtil {

   @SuppressWarnings("unchecked")
   public static <T> T clone(Object orgnObj, Object destObj) {

      Class<? extends Object> orgn = orgnObj.getClass();
      Class<? extends Object> dest = destObj.getClass();

      Field[] orgnFields = getAllField(orgn);
      Field[] destFields = getAllField(dest);

      Field orgnField = null;
      Field destField = null;

      for (int i = 0; i < orgnFields.length; i++) {
         orgnField = orgnFields[i];
         for (int j = 0; j < destFields.length; j++) {
            destField = destFields[j];

            if (orgnField.getName().equals(destField.getName())) {
               setAccessable(orgnField, destField);
               copyValue(orgnField, destField, orgnObj, destObj);
            }
         }
      }
      
      
      return (T) destObj;
   }

   private static Field[] getAllField(Class<? extends Object> orgnObj) {
      List<Field> allField = makeAllField(orgnObj, new ArrayList<Field>());
      Field[] fieldArray = new Field[allField.size()];
      return allField.toArray(fieldArray);
   }
   
   private static List<Field> makeAllField(Class<? extends Object> orgnObj, List<Field> fieldList) {
      
      if ( orgnObj != null && !orgnObj.getCanonicalName()
            .equalsIgnoreCase("java.lang.Object") ) {
         fieldList.addAll(Arrays.asList(orgnObj.getDeclaredFields()));
         makeAllField(orgnObj.getSuperclass(), fieldList);
      }
      return fieldList;
      
   }
   
   private static void setAccessable(Field orgnField, Field destField) {
      destField.setAccessible(true);
      orgnField.setAccessible(true);
   }

   private static void copyValue(Field orgnField, Field destField, Object orgnObj, Object destObj) {
      Object value = null;

      value = getValue(orgnField, orgnObj);

      try {
         if (value instanceof String) {
            destField.set(destObj, orgnField.get(orgnObj).toString());
         } else if (value instanceof Byte) {
            destField.setByte(destObj, getByte(orgnField, orgnObj));
         } else if (value instanceof Short) {
            destField.setShort(destObj, getShort(orgnField, orgnObj));
         } else if (value instanceof Integer) {
            destField.setInt(destObj, getInt(orgnField, orgnObj));
         } else if (value instanceof Boolean) {
            destField.setBoolean(destObj, getBoolean(orgnField, orgnObj));
         } else if (value instanceof Long) {
            destField.setLong(destObj, getLong(orgnField, orgnObj));
         } else if (value instanceof Float) {
            destField.setFloat(destObj, getFloat(orgnField, orgnObj));
         } else if (value instanceof Double) {
            destField.setDouble(destObj, getDouble(orgnField, orgnObj));
         } else {
            destField.set(destObj, orgnField.get(orgnObj));
         }
      } catch (IllegalArgumentException | IllegalAccessException e) {
         e.printStackTrace();
      }
   }

   private static Object getValue(Field field, Object obj) {
      try {
         return field.get(obj);
      } catch (IllegalArgumentException | IllegalAccessException e) {
         return null;
      }
   }

   private static boolean getBoolean(Field field, Object obj) {
      return Boolean.parseBoolean(getValue(field, obj).toString());
   }

   private static byte getByte(Field field, Object obj) {
      return Byte.parseByte(getValue(field, obj).toString());
   }

   private static short getShort(Field field, Object obj) {
      return Short.parseShort(getValue(field, obj).toString());
   }

   private static int getInt(Field field, Object obj) {
      return Integer.parseInt(getValue(field, obj).toString());
   }

   private static long getLong(Field field, Object obj) {
      return Long.parseLong(getValue(field, obj).toString());
   }

   private static float getFloat(Field field, Object obj) {
      return Float.parseFloat(getValue(field, obj).toString());
   }

   private static double getDouble(Field field, Object obj) {
      return Double.parseDouble(getValue(field, obj).toString());
   }

}
