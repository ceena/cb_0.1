package rulePack;

import java.io.Serializable;

public class clConditions implements Serializable{

	private String objType = null;
	
	public clConditions(String objType){
//		setObjectID(objID);
		setObjType(objType);
	}

	/*public String getObjectID() {
		return objectID;
	}

	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}*/

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}
}
