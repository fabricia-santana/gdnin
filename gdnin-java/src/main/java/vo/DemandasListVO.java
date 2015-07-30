package vo;

import java.util.List;

import model.Demanda;

public class DemandasListVO {
    private int pagesCount;
    private long totalDemandas;

    private String actionMessage;
    private String searchMessage;

    private List<Demanda> demandas;

    public DemandasListVO() {
    }

    public DemandasListVO(int pages, long totalDemandas, List<Demanda> demandas) {
        this.pagesCount = pages;
        this.demandas = demandas;
        this.totalDemandas = totalDemandas;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public List<Demanda> getDemandas() {
        return demandas;
    }

    public void setDemandas(List<Demanda> demandas) {
        this.demandas = demandas;
    }

    public long getTotalDemandas() {
        return totalDemandas;
    }

    public void setTotalDemandas(long totalDemandas) {
        this.totalDemandas = totalDemandas;
    }

    public String getActionMessage() {
        return actionMessage;
    }

    public void setActionMessage(String actionMessage) {
        this.actionMessage = actionMessage;
    }

    public String getSearchMessage() {
        return searchMessage;
    }

    public void setSearchMessage(String searchMessage) {
        this.searchMessage = searchMessage;
    }
}