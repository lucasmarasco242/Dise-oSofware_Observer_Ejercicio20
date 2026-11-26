public class SubsistAnalisisLegal implements ObservadorNormativo {
    public String obtenerEntidad() {
        return "AnalisisLegal";
    }

    public void alCambiarRiesgo(String cuentaId, String riesgoAnterior, String riesgoNuevo) throws Exception {
        if ("ALTO".equals(riesgoNuevo)) {
            throw new Exception("Revisión contractual pendiente en AnalisisLegal para " + cuentaId);
        }
        System.out.println("[ANALISIS LEGAL] Verificando cláusulas de cuenta " + cuentaId + " con riesgo " + riesgoNuevo);
    }
}