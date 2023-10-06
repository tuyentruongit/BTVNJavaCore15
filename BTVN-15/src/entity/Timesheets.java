package entity;

import java.util.List;
import java.util.Objects;

public class Timesheets {
    private Worker worker;
    private List<WorkShopDetail> workShopDetails ;

    public Timesheets(Worker worker, List<WorkShopDetail> workShopDetails) {
        this.worker = worker;
        this.workShopDetails = workShopDetails;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public List<WorkShopDetail> getWorkShopDetails() {
        return workShopDetails;
    }

    public void setWorkShopDetails(List<WorkShopDetail> workShopDetails) {
        this.workShopDetails = workShopDetails;
    }

    @Override
    public String toString() {
        return "Timesheets{" +
                "worker=" + worker +
                ", workShopDetails=" + workShopDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timesheets that = (Timesheets) o;
        return Objects.equals(worker, that.worker) && Objects.equals(workShopDetails, that.workShopDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(worker, workShopDetails);
    }
}
