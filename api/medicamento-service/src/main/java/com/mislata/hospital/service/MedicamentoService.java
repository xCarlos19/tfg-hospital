package com.mislata.hospital.service;

import java.util.List;

import com.mislata.hospital.model.Medicamento;
import com.mislata.hospital.model.dto.MedicamentoDTO;

public interface MedicamentoService {

	public List<MedicamentoDTO> getMedicamentos();
	public MedicamentoDTO getMedicamentoById(Integer id);
	public MedicamentoDTO insertMedicamento(MedicamentoDTO medicamento);
	public MedicamentoDTO updateMedicamento(MedicamentoDTO medicamento);
	public void deleteMedicamento(Integer id);
}
