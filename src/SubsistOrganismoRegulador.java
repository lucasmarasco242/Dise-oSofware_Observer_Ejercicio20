public class SubsistOrganismoRegulador implements ObservadorNormativo {
    public String obtenerEntidad() {
        return "OrganismoRegulador";
    }

    public void alCambiarRiesgo(String cuentaId, String riesgoAnterior, String riesgoNuevo) throws Exception {
        System.out.println("[ORGANISMO REGULADOR] Notificando cambio de cuenta " + cuentaId + " a " + riesgoNuevo);
    }
}