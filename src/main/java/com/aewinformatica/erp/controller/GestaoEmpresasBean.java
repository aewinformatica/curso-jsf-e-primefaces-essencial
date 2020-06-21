package com.aewinformatica.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.aewinformatica.erp.model.Empresa;
import com.aewinformatica.erp.repository.Empresas;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;
	
	private List<Empresa>listaEmpresas;
	
	public void todasEmpresas() {
		
		this.listaEmpresas = empresas.todas();
	}


	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	
}
