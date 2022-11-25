package dao;

import configDB.Conexao;
import entidade.UpdadeVo;

public class UpdateDAO {

	public void inserirDados() {
		Conexao c = new Conexao("localhost","5432","restUpdate","admin","admin");
		c.conect();
		UpdadeVo up = new UpdadeVo();
		String sql = "insert into update (id, idUpdate, currentR eleaseDate, cvrfUrl, documentTitle, initialReleaseDate, severity)"+
					  "values (default,"+up.getIdUpdate()+", "+up.getCurrentReleaseDate()+", "+up.getCvrfUrl()+", "+up.getDocumentTitle()+", "+up.getInitialReleaseDate()+", "+up.isSeverity()+")";
		int res = c.executaSQL(sql);
		c.disconect();
		if (res == 0) {
			System.out.println("Erro");
		}
	}
	
}
