public final class ReporteAuditoriaNormativa {
    private final String cuentaId;
    private final String riesgoAnterior;
    private final String riesgoNuevo;
    private final String[] exitosos;
    private final String[] incidencias;

    public ReporteAuditoriaNormativa(String cuentaId, String riesgoAnterior, String riesgoNuevo, String[] exitosos, String[] incidencias) {
        this.cuentaId = cuentaId;
        this.riesgoAnterior = riesgoAnterior;
        this.riesgoNuevo = riesgoNuevo;
        this.exitosos = exitosos;
        this.incidencias = incidencias;
    }

    public String getCuentaId() {
        return cuentaId;
    }

    public String getRiesgoAnterior() {
        return riesgoAnterior;
    }

    public String getRiesgoNuevo() {
        return riesgoNuevo;
    }

    public String[] getExitosos() {
        return exitosos;
    }

    public String[] getIncidencias() {
        return incidencias;
    }

    public String obtenerResumen() {
        String texto = "Auditoria [" + cuentaId + ": " + riesgoAnterior + " -> " + riesgoNuevo + "] Exitosos: ";
        if (exitosos.length == 0) {
            texto = texto + "ninguno";
        } else {
            for (int i = 0; i < exitosos.length; i++) {
                texto = texto + exitosos[i];
                if (i < exitosos.length - 1) {
                    texto = texto + ", ";
                }
            }
        }
        texto = texto + " | Incidencias: ";
        if (incidencias.length == 0) {
            texto = texto + "ninguna";
        } else {
            for (int i = 0; i < incidencias.length; i++) {
                texto = texto + incidencias[i];
                if (i < incidencias.length - 1) {
                    texto = texto + "; ";
                }
            }
        }
        return texto;
    }
}