package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyTeste {
	
	public void salvarParametros(String ipServer, String port) {
			        OutputStream out = null;
		        try {
		            // Cria o manipulador de propriedades
		            Properties props = new Properties();
			 
			            // Iremos Salvar no arquivo a propriedade ServerAddress
			            props.setProperty("ServerAddress", ipServer);
			 
			            // Iremos Salvar no arquivo a propriedade ServerPort
			            props.setProperty("ServerPort", "" + port);
			 
			            // Cria arquivo onde serao salvos as propriedades
			            File f = new File("server.properties");
			            out = new FileOutputStream(f);
			 
			            // grava conteudo no arquivo
			            props.store(out, "Cabecalho opcional para salvar no arquivo");
			 
			        } catch (Exception e) {
			        	javax.swing.JOptionPane.showMessageDialog(null, e);
			            e.printStackTrace();
			        } finally {
			            if (out != null) {
			                try {
			                    out.close();
			                } catch (IOException e) {
			                	javax.swing.JOptionPane.showMessageDialog(null, e);
			                    e.printStackTrace();
			                }
			            }
			        }
			    }
			 
			    public Properties carregarParametros() {
			        // Cria o manipulador de propriedades
			        Properties props = new Properties();
			 
			        // Classe usada para ler conteúdo do arquivo
			        InputStream is = null;
			 
			        // Tenta carregar arquivo
			        try {
			            File f = new File("c:\\temp\\server.properties");
			            is = new FileInputStream(f);
			        } catch (Exception e) {
			        	javax.swing.JOptionPane.showMessageDialog(null, e);
			            is = null;
			        }
			 
			        try {
			            if (is == null) {
			                is = getClass().getResourceAsStream("C:\\temp\\server.properties");
			            }
			 
			            // Tenta carregar propriedades do arquivo
			            props.load(is);
			        } catch (Exception e) {
			        	javax.swing.JOptionPane.showMessageDialog(null, e);
			            e.printStackTrace();
			        } finally {
			            if (is != null) {
			                try {
			                    is.close();
			                } catch (IOException e) {
			                	javax.swing.JOptionPane.showMessageDialog(null, e);
			                    e.printStackTrace();
			                }
			            }
			        }
			 
			        return props;
			    }
		

	public static void main(String[] args) {
		// Criando nossa classe
			        PropertyTeste nossaClasse = new PropertyTeste();
			 
			        // Salvando valores nas propriedades
			        nossaClasse.salvarParametros("200.192.3.1", "1002");
			 
			        // Carrega parametros salvos
			        Properties props = nossaClasse.carregarParametros();
			 
		        // Mostrando valores, caso não encontre o arquivo os valores padroes
			        // serao mostrados, no caso abaixo 127.0.0.1 ou na porta 1000
			        System.out.println(props.getProperty("ServerAddress", "127.0.0.1"));
			        System.out.println(props.getProperty("ServerPort", "1000"));
		

	}

}
