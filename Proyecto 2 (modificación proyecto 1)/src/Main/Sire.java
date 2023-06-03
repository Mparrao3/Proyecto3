package Main;

import java.io.FileWriter;
import java.io.IOException;

class Sire extends gatewayPago{
	private Boolean rslt=null;
	@Override
	void realizarPago(String resNumTarjeta, String resNombre,int csvTarjeta,String idReserva,int monto) {
		try (FileWriter fileWriter = new FileWriter("Datos/Sire.txt",true)) {
			String Texto=idReserva+","+monto+","+true;
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
