package com.manudev.ficct;

public class PCB {

    private int pid;
    private String imageName;
    private String blockRAM;
    public Byte[] registers;

    public PCB(){}

    public PCB(int pid, String imageName, String blockRAM, Byte[] registers) {
        this.pid = pid;
        this.imageName = imageName;
        this.blockRAM = blockRAM;
        this.registers = registers;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBlockRAM() {
        return blockRAM;
    }

    public void setBlockRAM(String blockRAM) {
        this.blockRAM = blockRAM;
    }

    public Byte[] getRegisters() {
        return registers;
    }

    public void setRegisters(Byte[] registers) {
        this.registers = registers;
    }
}
