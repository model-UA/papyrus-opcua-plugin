package at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.listener;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;

public class SetEditorEnabledListener implements IPropertyChangeListener {

	FieldEditor editor;
	Composite parent;
	
	public SetEditorEnabledListener(FieldEditor editor, Composite parent)
	{
		super();
		this.editor = editor;
		this.parent = parent;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
		boolean enabled = (boolean) event.getNewValue();
		this.editor.setEnabled(enabled, this.parent);

	}

}
