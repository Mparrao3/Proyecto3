package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Usuario {
    public HashMap<String, ArrayList<String>> mapaUsuarios = new HashMap<>();

    public boolean crearUsuario(String usuario, String contraseña) {
        if (this.mapaUsuarios.containsKey(usuario)) {
            return false;
        } else {
            ArrayList<String> infoUsuario = new ArrayList<>();
            infoUsuario.add(usuario);
            infoUsuario.add(contraseña);
            this.mapaUsuarios.put(usuario, infoUsuario);
            return true;
        }
    }

    public boolean verificarUsuario(String usuario, String contraseña) {
        if (this.mapaUsuarios.containsKey(usuario)) {
            ArrayList<String> mapa = this.mapaUsuarios.get(usuario);
            if (mapa.contains(contraseña)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public ArrayList<String> consultarFechas(String fechaInicial, String fechaFinal, ArrayList<Habitacion> habitaciones) {
        ArrayList<String> respuesta = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaInicio = LocalDate.parse(fechaInicial, formatter);
        LocalDate fechaFin = LocalDate.parse(fechaFinal, formatter);

        for (Habitacion habitacion : habitaciones) {
            HashMap<LocalDate, Boolean> fechasOcupadas = habitacion.getMapaFechas();
            Set<LocalDate> conjuntoClaves = fechasOcupadas.keySet();
            ArrayList<LocalDate> listaClaves = new ArrayList<>(conjuntoClaves);

            if (listaClaves.isEmpty() || (!fechaInicio.isAfter(listaClaves.get(listaClaves.size() - 1))
                    && !fechaFin.isBefore(listaClaves.get(0)))) {
                StringBuilder sb = new StringBuilder();
                sb.append("ID: ").append(habitacion.getId()).append("\n");
                sb.append("Ubicación: ").append(habitacion.getUbicacion()).append("\n");
                sb.append("Tipo: ").append(habitacion.getTipo()).append("\n");
                sb.append("Capacidad: ").append(habitacion.getCapacidad()).append("\n");
                sb.append("Vista: ").append(habitacion.isVista()).append("\n");
                sb.append("Balcón: ").append(habitacion.isBalcon()).append("\n");
                sb.append("Cocina: ").append(habitacion.isCocina()).append("\n");
                sb.append("Aire: ").append(habitacion.getAire()).append("\n");
                sb.append("Calefacción: ").append(habitacion.getCalefaccion()).append("\n");
                sb.append("TV: ").append(habitacion.getTv()).append("\n");
                sb.append("Cafetera: ").append(habitacion.getCafetera()).append("\n");
                sb.append("Ropa y tapetes: ").append(habitacion.getRopaYTapetes()).append("\n");
                sb.append("Plancha: ").append(habitacion.getPlancha()).append("\n");
                sb.append("Secador: ").append(habitacion.getSecador()).append("\n");
                sb.append("Voltaje AC: ").append(habitacion.getVoltajeAc()).append("\n");
                sb.append("Toma USB A: ").append(habitacion.getTomaUSBA()).append("\n");
                sb.append("Toma USB C: ").append(habitacion.getTomaUSBC()).append("\n");
                sb.append("Desayuno: ").append(habitacion.getDesayuno()).append("\n");
                sb.append("Parqueadero Pago: ").append(habitacion.getParqueaderoPagoH()).append("\n");
                sb.append("Parqueadero gratis: ").append(habitacion.getParqueaderoGratisH()).append("\n");
                sb.append("Piscina: ").append(habitacion.getPiscina()).append("\n");
                sb.append("Zonas Húmedas: ").append(habitacion.getZonasHumedas()).append("\n");
                sb.append("BBQ: ").append(habitacion.getBQQ()).append("\n");
                sb.append("Wifi: ").append(habitacion.getWifi()).append("\n");
                sb.append("Recepción 24/7: ").append(habitacion.getRecepcion24H()).append("\n");
                sb.append("Mascotas: ").append(habitacion.getMascotas()).append("\n");

                respuesta.add(sb.toString());
            }
        }
        return respuesta;
    }
}
