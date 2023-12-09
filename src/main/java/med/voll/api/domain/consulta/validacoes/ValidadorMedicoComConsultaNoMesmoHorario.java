package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamenteConsulta;

public class ValidadorMedicoComConsultaNoMesmoHorario {
    private ConsultaRepository repository;

    public void validar(DadosAgendamenteConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario =
                repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo " +
                    "horário");
        }
    }
}
