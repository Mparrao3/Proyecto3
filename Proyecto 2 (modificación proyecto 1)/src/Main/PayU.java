package Main;

import java.io.FileWriter;
import java.io.IOException;

class porPayU extends gatewayPago{
	private Boolean rslt=null;
	@Override
	void realizarPago(String resNumTarjeta, String resNombre,int csvTarjeta,String idReserva,int cantidad) {
		try (FileWriter fileWriter = new FileWriter("Datos/PayU.txt",true)) {
			String Texto=idReserva+","+cantidad+","+true;
			fileWriter.write(Texto);
			fileWriter.close();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		rslt = true;
	}

	@Override
	Boolean obtenerResultadoPago() {

		return rslt;
	}

}
