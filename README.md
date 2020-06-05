# papyrus-opcua-plugin
This project develops a Eclipse Papyrus Plugin which handles transforming UML Diagrams into OPC-UA information models.

## Prerequisites

### Papyrus UML Designer
The Plugin relies on an existing installation of Papyurs Eclipse Project https://www.eclipse.org/papyrus/. You can install it in Eclipse or download a optimized version from the project page https://www.eclipse.org/papyrus/download.html. The Plugin is developed using version 4.7.0.

### Install Eclipse SDK (optional)
If you want to build the plugin yourself you have to install the Eclispe SDK. This can be found in the Eclipse Project repository in the list of update sites.
Select the following items:
    - Eclipse SDK

### Install Designer Plugins
The Plugin depends on the availabillity of Papyrus Code Generators, therefore some Papyrus Designer Plugins need the be installed.
Add the following update Site to Papyrus: http://download.eclipse.org/modeling/mdt/papyrus/components/designer/
Then install the following items
- Papyrus base elements for code generation

### Installing the Plugin 
Download the .jar files from the latest release and drop them into the plugins folder of your Papyrus installation. 