
export const getAllPacientes = async () =>{

    const response = await fetch("http://localhost:8081/api/pacientes")
    const data = await response.json();


    return data;

}