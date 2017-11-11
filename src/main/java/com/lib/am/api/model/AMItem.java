package com.lib.am.api.model;

public class AMItem {

	int icon;
	int selectedIcon;
	String name;
	boolean selected;

	public AMItem(int icon, int selectedIcon, String name) {
		this.icon = icon;
		this.name = name;
		this.selectedIcon = selectedIcon;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getSelectedIcon() {
		return selectedIcon;
	}

	public void setSelectedIcon(int selectedIcon) {
		this.selectedIcon = selectedIcon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
