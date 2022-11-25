package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import entidade.UpdadeVo;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.UnmarshalException;
import jakarta.xml.bind.Unmarshaller;

public class ClienteApi {

	private static int HTTP_COD_SUCESSO = 200;

	public static void main(String[] args) throws JAXBException {

		try {

			URL url = new URL("https://api.msrc.microsoft.com/cvrf/v2.0/updates");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
				throw new RuntimeException("HTTP error code : " + con.getResponseCode());
			}
 
			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

			JAXBContext jaxbContext = JAXBContext.newInstance(UpdadeVo.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			UpdadeVo update = (UpdadeVo) jaxbUnmarshaller.unmarshal(br);

			System.out.println("------  Dados da Update  -------- \n");
			System.out.println("IdUpdate : " + update.getIdUpdate());
			System.out.println("CurrentReleaseDate : " + update.getCurrentReleaseDate());
			System.out.println("CvrfUrl: " + update.getCvrfUrl());
			System.out.println("DocumentTitle: " + update.getDocumentTitle());
			System.out.println("InitialReleaseDate: " + update.getInitialReleaseDate());
			System.out.println("Severity: " + update.isSeverity());

			con.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnmarshalException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
