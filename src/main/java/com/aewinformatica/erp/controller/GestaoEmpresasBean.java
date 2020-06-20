package com.aewinformatica.erp.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.aewinformatica.erp.model.Empresa;
import com.aewinformatica.erp.model.TipoEmpresa;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Empresa empresa = new Empresa();
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public TipoEmpresa[] getTiposEmpresa() {
		
		return TipoEmpresa.values();
	}
	
	public void salvar() {
		System.out.println("SALVOU!");
	}
	
	public String ajuda() {
		//Usando Navegação Implicita sem alterar a URI
		return "AjudaGestaoEmpresas";
	}
}
