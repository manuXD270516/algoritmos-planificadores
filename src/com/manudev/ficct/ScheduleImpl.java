package com.manudev.ficct;

public class ScheduleImpl implements ScheduleBehaviour {

    // Variables globales

    // Colas de administracion de tiempos en la CPU
    QueueImpl qRR; // Para round robbin

    QueueImpl[] qCp; // para colas de prioridad
    int N; // cantidad de colas de prioridad

    // Objeto en procesamiento
    public PCB PRUN;

    // Adjunta en procesamiento

    public ScheduleImpl() {
        N = 4; // 4 colas por defecto para prioridad

        PRUN = new PCB();

        qRR = new QueueImpl();
        qCp = new QueueImpl[N];
    }


    // Contador de Quantums
    int cq = 1;


    @Override
    public void planificadorBase() {
        if (AdmMem.Finalizo(PRUN)) {
            AdmMem.FreeMem(PRUN);
        } else {
            PRUN.registers = CPU.Registers;
            qRR.meter(PRUN);
        }
        PRUN = qRR.sacar();
        CPU.Registers = PRUN.registers;
    }


    @Override
    public void planificadorBase2() {
        if (AdmMem.Finalizo(PRUN) || cq == 1) {
            if (AdmMem.Finalizo(PRUN)) {
                AdmMem.FreeMem(PRUN);
            } else {
                PRUN.registers = CPU.Registers;
                qRR.meter(PRUN);
            }
            PRUN = qRR.sacar();
            cq = 0;
            CPU.Registers = PRUN.registers;
        }
    }


}
