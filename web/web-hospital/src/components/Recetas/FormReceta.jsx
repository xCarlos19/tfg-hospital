import { getAllMedicamentos, getMedicamentoById } from "../../services/medicamentos-service";
import { getAllPacientes } from "../../services/paciente-service";
import { postReceta } from "../../services/recetas-service";
import { useEffect, useState } from "react";
import { Button, Checkbox, Select } from "@chakra-ui/react";

export const FormReceta = () => {
    const nombreUsuario = JSON.parse(localStorage.getItem("user")).username;
    const [pacientes, setPacientes] = useState([]);
    const [medicamentos, setMedicamentos] = useState([]);
    const [receta, setReceta] = useState({
        nombreUsuario: nombreUsuario,
        descripcion: "",
        idPaciente: "",
        idsMedicamentos: [],
    })

    useEffect(() => {
        getAllMedicamentos().then(setMedicamentos)
    }, [])

    useEffect(() => {
        getAllPacientes().then(setPacientes)
    }, [])

    const handlePacienteChange = (e) => {
        setReceta({ ...receta, idPaciente: e.target.value });
    }

    const handleMedicamentosChange = (e) => {
        e.preventDefault();

        getMedicamentoById(e.target.value).then(data => {
            const index = receta.idsMedicamentos.findIndex(medicamento => medicamento.id == data.id);
            
            if (index == -1) {

                setReceta(prevState => ({
                    ...receta, idsMedicamentos: [...prevState.idsMedicamentos, data]
                }));
            } else {
                receta.idsMedicamentos.splice(index, 1);

            }

        });


    }

    const handleSubmit = (e) => {
        e.preventDefault()

        console.log(receta)
        postReceta(receta).then(data => {
            alert(data)
        }

        )

    }

    return (
        <>
            <h1>Pacientes</h1>
            <form onSubmit={handleSubmit}>
                <Select onChange={handlePacienteChange}>
                    {pacientes.map(p => (

                        <option key={p.idPaciente} value={p.idPaciente}>{p.nombre}</option>
                    ))}
                </Select>

                {
                    medicamentos.map(med => (
                        <>
                            <Checkbox key={med.id} value={med.id} onChange={handleMedicamentosChange} checked={(e) => console.log(e)}>{med.nombre}</Checkbox>

                        </>
                    ))
                }
                <Button type="submit"> Enviar</Button>

            </form>
        </>
    )


}