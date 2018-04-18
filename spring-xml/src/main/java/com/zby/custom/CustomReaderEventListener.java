package com.zby.custom;

import org.springframework.beans.factory.parsing.AliasDefinition;
import org.springframework.beans.factory.parsing.ComponentDefinition;
import org.springframework.beans.factory.parsing.DefaultsDefinition;
import org.springframework.beans.factory.parsing.ImportDefinition;
import org.springframework.beans.factory.parsing.ReaderEventListener;

public class CustomReaderEventListener implements ReaderEventListener {

	@Override
	public void defaultsRegistered(DefaultsDefinition defaultsDefinition) {
		System.out.println("defaultsRegistered:" + defaultsDefinition);

	}

	@Override
	public void componentRegistered(ComponentDefinition componentDefinition) {
		System.out.println("componentRegistered:" + componentDefinition);
	}

	@Override
	public void aliasRegistered(AliasDefinition aliasDefinition) {
		System.out.println("aliasRegistered:" + aliasDefinition);
	}

	@Override
	public void importProcessed(ImportDefinition importDefinition) {
		System.out.println("importProcessed:" + importDefinition);
	}

}
