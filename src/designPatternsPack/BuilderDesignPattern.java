package designPatternsPack;

class VehicleData
{
	private String oem;
    private	int vehicleNo;
    private	String vehType;
	public VehicleData(String oem, int vehicleNo, String vehType) {
		super();
		this.oem = oem;
		this.vehicleNo = vehicleNo;
		this.vehType = vehType;
	}
	public String getOem() {
		return oem;
	}
	
	public int getVehicleNo() {
		return vehicleNo;
	}
	
	
	public String getVehType() {
		return vehType;
	}
	static class Builder
	{
		private String oem;
	    private	int vehicleNo;
	    private	String vehType;
		public Builder setOem(String oem) {
			this.oem = oem;
			return this;
		}
		public Builder setVehicleNo(int vehicleNo) {
			this.vehicleNo = vehicleNo;
			return this;
		}
		public Builder setVehType(String vehType) {
			this.vehType = vehType;
			return this;
		}
		public VehicleData build()
		{
			return new VehicleData(oem, vehicleNo, vehType);
		}
	    
	}
	
}

public class BuilderDesignPattern {
public static void main(String[] args) {
	VehicleData data1 = new VehicleData.Builder().setOem("BMW").setVehicleNo(123).setVehType("SUV").build();
	System.out.println(data1.getOem()+ " \n"+ data1.getVehicleNo() +"\n"+data1.getVehType());
}
}
