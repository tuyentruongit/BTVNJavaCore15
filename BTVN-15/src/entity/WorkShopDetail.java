package entity;

public class WorkShopDetail {
    private WorkShop workShop;
    private int workingDays;

    public WorkShopDetail(WorkShop workShop, int workingDays) {
        this.workShop = workShop;
        this.workingDays = workingDays;
    }

    public WorkShop getWorkShop() {
        return workShop;
    }

    public void setWorkShop(WorkShop workShop) {
        this.workShop = workShop;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    @Override
    public String toString() {
        return "WorkShopDetail{" +
                "workShop=" + workShop +
                ", workingDays=" + workingDays +
                '}';
    }
}
