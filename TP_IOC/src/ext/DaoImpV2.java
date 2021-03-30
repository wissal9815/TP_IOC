package ext;

import dao.IDao;

public class DaoImpV2 implements IDao{

	@Override
	public double getData() {
		
		System.out.println("Version WebService");
		double data = 12;
		return data;
				
	}

}