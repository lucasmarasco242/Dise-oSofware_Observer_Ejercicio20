public interface ObservadorNormativo {
    String obtenerEntidad();
    void alCambiarRiesgo(String cuentaId, String riesgoAnterior, String riesgoNuevo) throws Exception;
}