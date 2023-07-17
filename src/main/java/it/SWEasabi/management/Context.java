package it.SWEasabi.management;

import java.util.List;

import com.google.gson.JsonObject;

import it.SWEasabi.management.DTO.Area;
import it.SWEasabi.management.DTO.Lamp;
import it.SWEasabi.management.DTO.Sensor;
import it.SWEasabi.management.kernel.AreaManager;
import it.SWEasabi.management.kernel.LampManager;
import it.SWEasabi.management.kernel.SensorManager;
import it.SWEasabi.management.services.AccessKeyService;
import it.SWEasabi.management.services.DTOBuilderService;
import it.SWEasabi.management.services.DatabaseConnectionService;
import it.SWEasabi.management.services.LocalAccessKeyService;
import it.SWEasabi.management.services.LocalDTOBuilderService;
import it.SWEasabi.management.services.LocalDatabaseConnectionService;

public class Context 
{
    private AccessKeyService keys;
    private DTOBuilderService dtobuilder;
    private DatabaseConnectionService dbservice;
    private LampManager lampManager;
    private SensorManager sensorManager;
    private AreaManager areaManager;
    
    public Context(AccessKeyService keys, DTOBuilderService dtobuilder)
    {
    	this.keys=keys;
    	this.dtobuilder=dtobuilder;
    	this.dbservice = new LocalDatabaseConnectionService(dtobuilder);
    	this.lampManager = new LampManager(this.dbservice);
    	this.sensorManager = new SensorManager(this.dbservice);
    	this.areaManager = new AreaManager(this.dbservice);
    }
    
    public String getLamp(int id)
    {
    	Lamp lampada = lampManager.getLamp(id);
    	
    	JsonObject res = new JsonObject();
    	res.addProperty("id", lampada.getId());
    	res.addProperty("idmisuratore", lampada.getMeasurerId());
    	res.addProperty("idarea", lampada.getAreaId());
    	res.addProperty("longitudine", lampada.getLongitude());
    	res.addProperty("latitudine", lampada.getLatitude());
    	res.addProperty("luminosita", lampada.getBrightness());
    	
    	return res.toString();
    }
    
    public String getLampsInArea(int idArea)
    {
    	List<Lamp> lampade = lampManager.getLampsInArea(idArea);
    	String response = "";
    	
    	for(Lamp lampada : lampade)
    	{
    		JsonObject res = new JsonObject();
        	res.addProperty("id", lampada.getId());
        	res.addProperty("idmisuratore", lampada.getMeasurerId());
        	res.addProperty("idarea", lampada.getAreaId());
        	res.addProperty("longitudine", lampada.getLongitude());
        	res.addProperty("latitudine", lampada.getLatitude());
        	res.addProperty("luminosita", lampada.getBrightness());
        	response = response + res.toString();
    	}
    	
    	return response;
    }
    
    public boolean insertLamp(int idArea, double longitudine, double latitudine, int valore)
    {
    	return lampManager.insertLamp(idArea, longitudine, latitudine, valore);
    }
    
    public boolean deleteLamp(int id)
    {
    	return lampManager.deleteLamp(id);
    }
    
    public String getSensor(int id)
    {
    	Sensor sensore = sensorManager.getSensor(id);
    	
    	JsonObject res = new JsonObject();
    	res.addProperty("id", sensore.getId());
    	res.addProperty("idmisuratore", sensore.getMeasurerId());
    	res.addProperty("idarea", sensore.getAreaId());
    	res.addProperty("longitudine", sensore.getLongitude());
    	res.addProperty("latitudine", sensore.getLatitude());
    	res.addProperty("luminosita", sensore.getRadius());
    	
    	return res.toString();
    }
    
    public boolean insertSensor(int idArea, double longitudine, double latitudine, int valore)
    {
    	return sensorManager.insertSensor(idArea, longitudine, latitudine, valore);
    }
    
    public boolean deleteSensor(int id)
    {
    	return sensorManager.deleteSensor(id);
    }
    
    public boolean moveMeasurer(int idMis, int idArea)
    {
    	return areaManager.moveMeasurer(idMis, idArea);
    }
    
    public String getArea(int id)
    {
    	Area area = areaManager.getArea(id);
    	
    	JsonObject res = new JsonObject();
    	res.addProperty("id", area.getId());
    	res.addProperty("nome", area.getNome());
    	res.addProperty("auto", area.isAuto());
    	res.addProperty("inferiore", area.getInf());
    	res.addProperty("superiore", area.getSup());
    	
    	return res.toString();
    }
    
    public String getAreaList()
    {
    	List<Area> aree = areaManager.getAreaList();
    	String response = "";
    	
    	for(Area area : aree)
    	{
    		JsonObject res = new JsonObject();
        	res.addProperty("id", area.getId());
        	res.addProperty("nome", area.getNome());
        	res.addProperty("auto", area.isAuto());
        	res.addProperty("inferiore", area.getInf());
        	res.addProperty("superiore", area.getSup());
        	response = response + res.toString();
    	}
    	
    	return response;
    }
    
    public boolean editAreaName(int id, String nome)
    {
    	return areaManager.editAreaName(id, nome);
    }
    
    public boolean insertArea(String nome, boolean auto, int inf, int sup)
    {
    	return areaManager.insertArea(nome, auto, inf, sup);
    }
    
    public boolean deleteArea (int id)
    {
    	return areaManager.deleteArea(id);
    }
    
}
