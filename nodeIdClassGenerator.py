import csv
import os.path

def readNodeIdCsv(file):
    file_path = os.path.abspath(file)
    nodeIdList = []
    with open(file_path, newline='') as csvfile:
        nodeIdReader = csv.reader(csvfile, delimiter=',', quotechar='|')
        for row in nodeIdReader:
            nodeId = {}
            nodeId["name"] = row[0]
            nodeId["id"] = row[1]
            nodeId["type"] = row[2]
            nodeIdList.append(nodeId)
        # end for
    # end with

    return nodeIdList
# end def

def createJavaNodeIdListMembers(nodeIdList, type_filter=[]):
    idListentry = '\t\t\tadd(new NodeId("{name}","{id}","{type}"));'
    memberString = ""
    for node in nodeIdList:
        
        if(node["type"] in type_filter or len(type_filter) == 0):
            memberString += idListentry.format(**node) + "\n"
        #end if
    #end for

    return memberString
#end def

def createJavaNodeIdListClass(nodeIdList, className, type_filter=[]):
    classContent_upperPart = """import java.util.ArrayList;

public class """+className+"""
{	
	ArrayList<NodeId> id_list = new ArrayList<NodeId>() { 
        { 
"""
    classContent_lowerPart = """
        } 
    };
    
    public static String getDataTypeNodeId(String typeName)
    {
    	for(NodeId node : id_list)
    	{
    		if(node.name == typeName)
    		{
    			return node.id;
    		}
    	}
    	return "";
    }
    
    public static Boolean dataTypeNodeIdExists(String typeName)
    {
    	for(NodeId node : id_list)
    	{
    		if(node.name == typeName)
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public static void addDataType(String name, String id)
    {
    	id_list.add(new NodeId(name, id, "DataType"));
    }

}

class NodeId 
{
	String name;
	String id;
	String type;
	public NodeId(String name, String id, String type)
	{
		this.name = name;
		this.id = id;
		this.type = type;
	}
}
"""
    classContent  = classContent_upperPart
    classContent += createJavaNodeIdListMembers(nodeIdList, type_filter)
    classContent += classContent_lowerPart
    return classContent
# end def

def createJavaDataTypeNodeIdList(csv_file, java_file, class_name):
    if(not java_file.endswith(".java")):
        java_file = os.path.join(java_file, "DataTypeNodeIdList.java")
    # end if
    nodeIdList = readNodeIdCsv(csv_file)
    javaContent = createJavaNodeIdListClass(nodeIdList, class_name, ["DataType"])

    with  open(java_file, "w") as javaFileObj:
        javaFileObj.write(javaContent)
    # end with
# end def

def createJavaReferenceTypeNodeIdList(csv_file, java_file, class_name):
    if(not java_file.endswith(".java")):
        java_file = os.path.join(java_file, "ReferenceTypeNodeIdList.java")
    # end if
    nodeIdList = readNodeIdCsv(csv_file)
    javaContent = createJavaNodeIdListClass(nodeIdList, class_name, ["ReferenceType"])

    with  open(java_file, "w") as javaFileObj:
        javaFileObj.write(javaContent)
    # end with
# end def

def createJavaObjectTypeNodeIdList(csv_file, java_file, class_name):
    if(not java_file.endswith(".java")):
        java_file = os.path.join(java_file, "ObjectTypeNodeIdList.java")
    # end if
    nodeIdList = readNodeIdCsv(csv_file)
    javaContent = createJavaNodeIdListClass(nodeIdList, class_name, ["ObjectType"])

    with  open(java_file, "w") as javaFileObj:
        javaFileObj.write(javaContent)
    # end with
# end def

def createJavaObjectNodeIdList(csv_file, java_file, class_name):
    if(not java_file.endswith(".java")):
        java_file = os.path.join(java_file, "ObjectNodeIdList.java")
    # end if
    nodeIdList = readNodeIdCsv(csv_file)
    javaContent = createJavaNodeIdListClass(nodeIdList, class_name, ["Object"])

    with  open(java_file, "w") as javaFileObj:
        javaFileObj.write(javaContent)
    # end with
# end def

def createJavaVariableTypeNodeIdList(csv_file, java_file, class_name):
    if(not java_file.endswith(".java")):
        java_file = os.path.join(java_file, "VariableTypeNodeIdList.java")
    # end if
    nodeIdList = readNodeIdCsv(csv_file)
    javaContent = createJavaNodeIdListClass(nodeIdList, class_name, ["VariableType"])

    with  open(java_file, "w") as javaFileObj:
        javaFileObj.write(javaContent)
    # end with
# end def


