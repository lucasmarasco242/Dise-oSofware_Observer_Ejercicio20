public class SubsistPrevencionLavado implements ObservadorNormativo {
    public String obtenerEntidad() {
        return "PrevencionLavado";
    }

    public void alCambiarRiesgo(String cuentaId, String riesgoAnterior, String riesgoNuevo) throws Exception {
        if (riesgoNuevo == null || riesgoNuevo.isEmpty()) {
            throw new Exception("Nivel de riesgo vacío en PrevencionLavado.");
        }
        System.out.println("[PREVENCION LAVADO] Revisando movimientos de cuenta " + cuentaId + " (" + riesgoAnterior + " -> " + riesgoNuevo + ")");
    }
}