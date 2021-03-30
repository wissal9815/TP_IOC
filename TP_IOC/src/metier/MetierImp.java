package metier;

import dao.IDao;

public class MetierImp implements IMetier{

	private IDao dao;
	@Override
	public double calcul() {
		
		double d = dao.getData();
		double res = d*23;
		return res;
	}
	public IDao getDao() {
		return dao;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	

}
