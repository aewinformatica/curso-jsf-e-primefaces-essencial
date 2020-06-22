package com.aewinformatica.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.aewinformatica.erp.model.Empresa;
import com.aewinformatica.erp.model.TipoEmpresa;
import com.aewinformatica.erp.repository.Empresas;
import com.aewinformatica.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;
	
	@Inject
	private FacesMessages messages;
	
	private List<Empresa>listaEmpresas;
	
	private String termoPesquisa;
	
	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);
		
		if(listaEmpresas.isEmpty()) {
			messages.info("Sua consulta nao retornou registros.");
		}
	}
	public void todasEmpresas() {
		
		this.listaEmpresas = empresas.todas();
	}


	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}


	public String getTermoPesquisa() {
		return termoPesquisa;
	}


	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public TipoEmpresa[] getTiposEmpresa() {
		
		return TipoEmpresa.values();
	}
	
}
