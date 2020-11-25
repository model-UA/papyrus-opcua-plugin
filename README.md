# papyrus-opcua-plugin
This project develops several features extending Eclipse Papyrus which handles modelling of OPC-UA information models.

## Prerequisites

### Java Version

The Plugin requires at least Java version 11.

### Papyrus
The Features reliy on an existing installation of Papyurs Eclipse Project https://www.eclipse.org/papyrus/. You can install it in Eclipse or download a optimized version from the project page https://www.eclipse.org/papyrus/download.html. The Plugin is developed using Papyrus version 2020-06.

## Installation 

### Preperation

Open Papyrus and go to Help-->Check for Updates and bring the installation up to date and restart if required.

If not already installed the plugin Requires a version of "Papyrus for UML Developer Resources" greater or equal to 5.0.0

### Adding Update-Site
The Plugin is provided via the model-ua update site :  https://model-ua.auto.tuwien.ac.at/updates/releases

Open Papyrus and go to Help-->Install New Software, click on Add and enter the link.

![](doc/img/add_update_site.png)


### Adding Archive as Update-Site

Alternatively the releases can be downloaded here as archives : https://github.com/model-UA/papyrus-opcua-plugin/releases 

Open Papyrus and go to Help-->Install New Software, click on Add and then on Local or Archive depending if you extracted the archive or not.

### OPC UA Modelling Features

If the last step was successful you should be able to find the following packages:

![](doc/img/update_site_packages.png)

OPC UA NodeSet SDK provides the underlying functions required for reading and writing to NodeSet files.

OPC UA Profile provides a UML Profile which eases creation of OPC UA Information Models.

OPC UA Companion Specifications provides UML models of the NodeSets provided by the companion specifications.

OPC UA Modelling provides a new Diagram Type for Papyrus according to the graphical notation of the OPC UA Foundation.

### Diagram Installation 

To get the OPC UA Modelling option inside Papyrus install the following packages:
    - OPC UA NodeSet SDK
    - OPC UA Profile
    - OPC UA Companion Specifications
    - OPC UA Modelling

When the installation is done restart Papyrus.

## Usage

### Creating new Models

When creating a new Model select the Architecture Context OPC UA/Informationmodel:

![](doc/img/create_opc_ua_model_architecture_context.png)

As the tool does not automatically generate any namespaces it's better to create the Diagrams itself later. When clicking on finish, it may take a minute until the new model is initialized and the namespace 0 elements are loaded.

### Start Modelling
The first step which should be done is creating a namespace, this can be done by right clicking on the root element of your model in the Model Explorer. In the now opened context menu there is a entry NodeSet and in there is an entry Namespace. 

![](doc/img/create_namespace.png)

After creating the namespace, the URI can be set inside the propoerties tab:

![](doc/img/set_namespace_URI.png)

The next step is to create a NodeSet Diagram by right clicking on the created namespace element inside the Model Explorer. In the context menu click on New Diagram and then on NodeSetDiagram.

![](doc/img/new_nodeset_diagram.png)

On the right side of the diagram the following palette is shown. It can be used to directly drag and drop new elements into the Diagram.

![](doc/img/palette.png)

Each Element can be configured in the Profile page inside the properties page. That a configuration of an UANode (UAObjectType, UAMethod,...) is valid at least the browseName and the NodeID need to be set.

![](doc/img/element_configuration.png)

For creatign Rerferences between Elements click on the Reference entry in the palette and connect the desired diagram elements. In the Profile page inside the Properties Tab, the the direction of the Reference and the desired ReferenceType can selected. By clicking on the Button with the 3 dots all available ReferenceTypes can be browsed through, including namespace 0 and all imported Namespaces. 

As the Namespace 0 is automatically loaded all elements from it can be used and draged from the Model Explorer into the diagram and used with References.

### Non-Graphical Elements#

Not all elements required for modelling are part of the Graphical notation, e.g. RolePermissions. These elements can be added via the Model Explorer, right click on an element of your model and select the desired item. Again the configuration options are in the Profile page inside the Properties tab. Afterwards the model member can be referenced in the element.

### Displaying Configuration Entries

Per default no entry of the element is displayed in the diagram, to do this select the desired object in the diagram an open the Appearance page inside the Properties tab. Scroll to Stereotype display and check the top most entry in the In Comment collumn, afterwards deselect every entry which shall not be displayed.

### Exporting the NodeSet

On every save of the model a NodeSet file will be generated in the backgraound and is stored in the project directoy. It has the same name as your model file, but with a xml file extension.

If you want to directly export your diagram to a dedicated location this can be done via Export menu of Papyrus. Right click on an Element of your model inside the Model Explorer, under Export select Export NodeSet Informationmodel. 

![](doc/img/export_nodeset.png)

An export to this location can also be done automatically via the preferences. Go to Window --> Preferences and select the OPC UA page. First configure the Default Export directory and then check "Automatically generate a NodeSet file on save inside the default export directory". If the project folder shall be taken over also check "Create folder hierarchy of NodeSet file inside default export folder".  

### Importing NodeSet

On every save a NodeSet file corresponding to the model is generated, this NodeSet file can also be used by other applications and will be loaded if it was changed. 

For importing a NodeSet to use inside your model right click on an Element of your model inside the Model Explorer, under Import select Import NodeSet Model and select the corresponding UML file of the Informationmodel. If a NodeSet shall be imported and the loaded model shall be updated accordingliny use Update NodeSet instead.

### Configuration Options

The preferences for the diagram can be found under Window --> Preferences and then select the OPC UA page. 
The default import and export directories are used as a starting point for the file browsers when e.g. exporting a NodeSet.

The default NodeId scheme can be selected to be either automatic type selection depending on the content of the NodeId field or always use the string scheme.

If other tools use the automatic generated NodeSet file but the changes shall not be synched back, uncheck "Automatically relaod NodeSet if underlaying NodeSet file is changed"

Console log output level can be changed depending on the desired verbosity, this is only relevant for tracing bugs or issues with the model.

## Development and Build

### Depencies

Some additional dependencies are required for building the plugin.

#### Eclipse SDK

If you want to build or debug the plugin yourself you have to install the Eclispe SDK. This can be found in the Eclipse Project repository (e.g. http://download.eclipse.org/eclipse/updates/4.16/)  in the list of update sites.
Select the following items:
  - Eclipse SDK

#### Maven

The plugin is built for deployment using maven, therefore the maven plugin for eclipse (m2e) can be used. The plugin can be installed from http://download.eclipse.org/technology/m2e/releases . Select the following plugins:
  - m2e - Maven Integration for Eclipse 

After restarting eclipse open Window->Preferences and go to Maven->Discovery . Click on Open Catalog and install Tycho Configurator. Tycho is a maven plugin which eases the build of eclipse plugins, features and update-sites. If Maven is installed on the host system the plugin can be built executing ```mvn clean install``` inside the root directoy of the repository.

#### Additonal Papyrus depencies

If the underlaying UML model used for the diagram shall be adapted install the following from the papyrus update site:
  - Papyrus Toolsmith Tools 
  - Papyrus Diagram Assistants Generator 

### Updating the UML Profile

The plugin at.ac.tuwien.auto.modelua.papyrus.opcua.profile provides the underlying UML Profile for the diagram. The file itself can be found under resources/profile/UANodeSet.profile.umml. If the profile is changed ElementType files and the CreationMenu file need to be regnerated. 

For the ElementTypes open the Profile and right click inside the Model Exlporer on the root Element of the Profile. Select Generate Tooling Model --> ElementTypes. Use at.ac.tuwien.auto.modelua.papyrus.opcua.nodeset as id and select UMLElementTypeSet as Base element type set. Set the parten folder to at.ac.tuwien.auto.modelua.papyrus.opcua.diagram/resources/elementtypes and the filename to UANodeSet.elementtypesconfigurations .

For the DI ElementTypes open again Generate Tooling Model --> ElementTypes. Use at.ac.tuwien.auto.modelua.papyrus.opcua.nodeset as id and select UMLDIElementTypeSet as Base element type set. Check both "Suppress semantic parent in diagram-specific element types" and "Add .di postfix to identifier in diagram-specific element types". Set the parten folder to at.ac.tuwien.auto.modelua.papyrus.opcua.diagram/resources/elementtypes and the filename to UANodeSet.di.elementtypesconfigurations .

As the ElementTypes changed the corresponding CreationMenuModel needs to be regnerated, also known as New Child Menu. Therefore right click on UANodeSet.elementtypesconfigurations and select "Create New Child Menu". 

### Adding/Updating Companion Specifications

Currenlty only Companion Specification Information Models are supported. 

The UML Models for the companion specifications are located at.ac.tuwien.auto.modelua.papyrus.opcua.librareis plugin under resources/libraries.

To update an Information Model open the corresponding UML model and use the "Update NodeSet" Import option to update the content. 

To add a new Compion Specification create a OPC UA Diagram with the name of the NodeSet file as Name of the Model and the root element. Then use the "Update NodeSet" Import option to load the content. Create a new folder resources/libraries with the name of the companion spec. To make the specification visible in Papyrus open the plugin.xml file inside at.ac.tuwien.auto.modelua.papyrus.opcua.libraries and open the extensions tab. Add a new org.eclipse.papyrus.uml.extensionpoints.UMLLibrary extension and configure the paths accordingly. Next open OpcUaLibraryResources.java inside the package at.ac.tuwien.auto.modelua.papyrus.opcua.libraries. Add a new entry NAMESPACE_PACKAGE_MAPPING, the first element is the namespace, the second is the file location.

## Papyrus code generator based Transformation

This is deprecated as the programmatic aproach was not further developed, please check out https://github.com/model-UA/uml-to-opcua for more transformation aproaches. 

### Prerequisites 

#### Install Designer Plugins
The Plugin depends on the availabillity of Papyrus Code Generators, therefore some Papyrus Designer Plugins need the be installed.
Add the following update Site to Papyrus: http://download.eclipse.org/modeling/mdt/papyrus/components/designer/
Then install the following items
- Papyrus base elements for code generation

#### Installing the Plugin 
Download the .jar files from the latest release and drop them into the plugins folder of your Papyrus installation. 
Current Release https://github.com/model-UA/papyrus-opcua-plugin/releases/tag/v0.0.1-beta1 

### Using the Plugin

Currently the Plugin only supports transformation of Class Diagrams and no output of errors. Errornous entries will be ignored.
A Information Model can be generated by right clicking into a Diagram and selcting the Menu entry Designer->Generate OPC-UA Information Model 

#### Error Logging
Not everything which is modelled in UML can be transformed into OPC-UA information models. Transformation Errors will be shown insided the Error Log of Papyrus which can be shown via Window->Show View->Error Log. Each log entry shows the qualified name of the UML and what the error is. 

### Debugging the Plugin
With the source code the plugin can debugged inside the Papyrus installation.

#### Loading the the Plugin
First the following folders have to imported as Eclipse Project into the Workspace. 
 - org.eclipse.papyrus.designer.languages.opcua.codegen
 - org.eclipse.papyrus.designer.languages.opcua.codegen.ui

Finally run or debug as Eclipse Application. 
