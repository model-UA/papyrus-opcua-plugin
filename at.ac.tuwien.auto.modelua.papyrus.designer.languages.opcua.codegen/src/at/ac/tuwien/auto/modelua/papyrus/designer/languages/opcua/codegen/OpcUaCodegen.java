/**
 * 
 */
package at.ac.tuwien.auto.modelua.papyrus.designer.languages.opcua.codegen;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.designer.languages.common.extensionpoints.ILangCodegen2;
import org.eclipse.papyrus.designer.languages.common.extensionpoints.MethodInfo;
import org.eclipse.papyrus.designer.languages.common.extensionpoints.SyncInformation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;

public class OpcUaCodegen implements ILangCodegen2 {

	/**
	 * 
	 */
	public OpcUaCodegen() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.designer.languages.common.extensionpoints.ILangCodegen2#getDescription()
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.designer.languages.common.extensionpoints.ILangCodegen2#getSuffix(org.eclipse.papyrus.designer.languages.common.extensionpoints.ILangCodegen.FILE_KIND)
	 */
	@Override
	public String getSuffix(FILE_KIND arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.designer.languages.common.extensionpoints.ILangCodegen2#getSyncInformation(java.lang.String, java.lang.String)
	 */
	@Override
	public SyncInformation getSyncInformation(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cleanCode(IProject arg0, PackageableElement arg1, IProgressMonitor arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateCode(IProject arg0, PackageableElement arg1, IProgressMonitor arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFileName(IProject arg0, NamedElement arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IProject getTargetProject(PackageableElement arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MethodInfo getMethodInfo(NamedElement arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEligible(Element arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
