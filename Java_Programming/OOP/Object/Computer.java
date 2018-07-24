package Object;

import java.util.ArrayList;
import java.util.List;

public class Computer {

	private String cpu;
	private String gpu;
	private List<String> ramList;
	private List<String> hddList;
	private List<String> ssdList;
	
	public Computer() {
		this.cpu = "intel";
		this.gpu = "gpu";
		
		this.ramList = new ArrayList<String>();
		this.ramList.add("16GB");
		this.hddList = new ArrayList<String>();
		this.hddList.add("1TB");
		this.ssdList = new ArrayList<String>();
		this.ssdList.add("256GB");
		
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		if( cpu.toLowerCase().startsWith("intel") ) {
			this.cpu = cpu;
		}
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		if( gpu.toLowerCase().startsWith("nvdia") ) {
			this.gpu = gpu;
		}
	}

	public List<String> getRamList() {
		List<String> ramListCopy = new ArrayList<String>();
		ramListCopy.addAll(this.getRamList());
		return ramListCopy;
	}

	public void setRamList(List<String> ramList) {
		List<String> setRamList = new ArrayList<String>();
		setRamList.addAll(ramList);
		this.ramList = setRamList;
	}

	public List<String> getHddList() {
		List<String> hddListCopy = new ArrayList<String>();
		hddListCopy.addAll(this.getHddList());
		return hddListCopy;
	}

	public void setHddList(List<String> hddList) {
		List<String> setHddList = new ArrayList<String>();
		setHddList.addAll(hddList);
		this.hddList = setHddList;
	}

	public List<String> getSsdList() {
		List<String> ssdListCopy = new ArrayList<String>();
		ssdListCopy.addAll(this.getSsdList());
		return ssdListCopy;
	}

	public void setSsdList(List<String> ssdList) {
		List<String> setSsdList = new ArrayList<String>();
		setSsdList.addAll(ssdList);
		this.ssdList = setSsdList;
	}

}
