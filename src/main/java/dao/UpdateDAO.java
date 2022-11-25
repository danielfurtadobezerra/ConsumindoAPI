package dao;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import configDB.Conexao;
import entidade.UpdadeVo;

public class UpdateDAO {
	
	ScheduledExecutorService scheduledExecutorService =
	        Executors.newScheduledThreadPool(1);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	ScheduledFuture scheduledFuture =
		    scheduledExecutorService.schedule(new Callable() {
		    	public void inserirDados() {
		    		Conexao c = new Conexao("localhost","5432","restUpdate","postgres","postgres");
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

				@Override
				public Object call() throws Exception {
					// TODO Auto-generated method stub
					return null;
				}
		    },
		    300,
		    TimeUnit.SECONDS);
}

