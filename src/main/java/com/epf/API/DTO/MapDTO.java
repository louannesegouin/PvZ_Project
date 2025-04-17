package com.epf.API.DTO;

public class MapDTO {
    private Long id;
    private int rows;
    private int columns;
    private String pathimage;

    // Constructeurs, getters et setters
    public MapDTO(Long id, int rows, int columns, String pathimage) {
        this.id = id;
        this.rows = rows;
        this.columns = columns;
        this.pathimage = pathimage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public String getPathimage() {
        return pathimage;
    }

    public void setPathimage(String pathimage) {
        this.pathimage = pathimage;
    }
}

