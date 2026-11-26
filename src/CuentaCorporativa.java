public class CuentaCorporativa {
    private String cuentaId;
    private String nivelRiesgo;
    private ObservadorNormativo[] observadores = new ObservadorNormativo[20];
    private int cantidad = 0;

    public CuentaCorporativa(String cuentaId, String nivelRiesgoInicial) {
        this.cuentaId = cuentaId;
        this.nivelRiesgo = nivelRiesgoInicial;
    }

    public synchronized void suscribir(ObservadorNormativo observador) {
        if (observador == null || cantidad >= observadores.length) {
            return;
        }
        for (int i = 0; i < cantidad; i++) {
            if (observadores[i] == observador) {
                return;
            }
        }
        observadores[cantidad] = observador;
        cantidad++;
    }

    public synchronized void desuscribir(ObservadorNormativo observador) {
        for (int i = 0; i < cantidad; i++) {
            if (observadores[i] == observador) {
                for (int j = i; j < cantidad - 1; j++) {
                    observadores[j] = observadores[j + 1];
                }
                observadores[cantidad - 1] = null;
                cantidad--;
                return;
            }
        }
    }

    public synchronized ReporteAuditoriaNormativa actualizarRiesgo(String nuevoRiesgo) {
        String anterior = this.nivelRiesgo;
        this.nivelRiesgo = nuevoRiesgo;

        ObservadorNormativo[] copia = new ObservadorNormativo[cantidad];
        for (int i = 0; i < cantidad; i++) {
            copia[i] = observadores[i];
        }

        String[] tempExitosos = new String[copia.length];
        String[] tempIncidencias = new String[copia.length];
        int cantExitosos = 0;
        int cantIncidencias = 0;

        for (int i = 0; i < copia.length; i++) {
            ObservadorNormativo obs = copia[i];
            try {
                obs.alCambiarRiesgo(cuentaId, anterior, nuevoRiesgo);
                tempExitosos[cantExitosos] = obs.obtenerEntidad();
                cantExitosos++;
            } catch (Exception e) {
                tempIncidencias[cantIncidencias] = obs.obtenerEntidad() + ": " + e.getMessage();
                cantIncidencias++;
            }
        }

        String[] exitososFinal = new String[cantExitosos];
        for (int i = 0; i < cantExitosos; i++) {
            exitososFinal[i] = tempExitosos[i];
        }

        String[] incidenciasFinal = new String[cantIncidencias];
        for (int i = 0; i < cantIncidencias; i++) {
            incidenciasFinal[i] = tempIncidencias[i];
        }

        return new ReporteAuditoriaNormativa(cuentaId, anterior, nuevoRiesgo, exitososFinal, incidenciasFinal);
    }
}