package com.serotonin.mango.vo.report;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.serotonin.util.SerializationHelper;

public class ReportPointVO implements Serializable {
    private int pointId;
    private String colour;
    private boolean consolidatedChart;
    private String title;
    private String xlabel;
    private String ylabel;
    private int referenceLines;
    private boolean scatterPlot;

    public String getTitle() {
    	return title;
	}
	public String getXlabel() {
    	return xlabel;
	}
	public String getYlabel() {
    	return ylabel;
	}
	public int getReferenceLines() {
    	return referenceLines;
	}
    public boolean isScatter(){
        return scatterPlot;
    }

    public void setTitle(String title) {
    	this.title = title;
	}
	public void setXlabel(String xlabel) {
    	this.xlabel = xlabel;
	}
	public void setYlabel(String ylabel) {
    	this.ylabel = ylabel;
	}
	public void setReferenceLines(int referenceLines) {
    	this.referenceLines = referenceLines;
	}
    public void setScatterPlot(boolean scatterPlot){
        this.scatterPlot = scatterPlot;
    }


    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isConsolidatedChart() {
        return consolidatedChart;
    }

    public void setConsolidatedChart(boolean consolidatedChart) {
        this.consolidatedChart = consolidatedChart;
    }

    //
    //
    // Serialization
    //
    private static final long serialVersionUID = -1;
    private static final int version = 2;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(version);
        out.writeInt(pointId);
        SerializationHelper.writeSafeUTF(out, colour);
        out.writeBoolean(consolidatedChart);
    }

    private void readObject(ObjectInputStream in) throws IOException {
        int ver = in.readInt();

        // Switch on the version of the class so that version changes can be elegantly handled.
        if (ver == 1) {
            pointId = in.readInt();
            colour = SerializationHelper.readSafeUTF(in);
            consolidatedChart = true;
        }
        else if (ver == 2) {
            pointId = in.readInt();
            colour = SerializationHelper.readSafeUTF(in);
            consolidatedChart = in.readBoolean();
        }
    }
}
