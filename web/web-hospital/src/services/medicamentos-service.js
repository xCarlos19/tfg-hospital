


export const getAllMedicamentos = async () =>{
    
    const token = JSON.parse(localStorage.getItem("user")).token;
        
        const requestOptions = {
            method: 'GET',
            headers: { "Authorization" : `Bearer ${token}` },
        };
        
        const response = await fetch("http://localhost:8081/api/medicamentos", requestOptions);
        const data = await response.json();
        return data;

    
    
}

export const postMedicamento = async (medicamento) => {
const token = JSON.parse(localStorage.getItem("user")).token;
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' ,
                "Authorization" : `Bearer ${token}` } ,
        body: JSON.stringify(medicamento)
    };

    const response =  await fetch("http://localhost:8081/api/medicamentos", requestOptions);
    const data = await response.json();

    return data;

}
export const putMedicamento = async (medicamento) => {
    const token = JSON.parse(localStorage.getItem("user")).token;
        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' ,
                    "Authorization" : `Bearer ${token}` } ,
            body: JSON.stringify(medicamento)
        };
    
        const response =  await fetch("http://localhost:8081/api/medicamentos/"+medicamento.id, requestOptions);
        const data = await response.json();
    
        return data;
    
    }
export const deleteMedicamento = async (id) => {
    const token = JSON.parse(localStorage.getItem("user")).token;
        const requestOptions = {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' ,
                    "Authorization" : `Bearer ${token}` } ,
            
        };
    
        const response =  await fetch("http://localhost:8081/api/medicamentos/"+id, requestOptions);
        const data = await response.json();
    
        
    
    }


    export const getMedicamentoById = async (id) => {
        const token = JSON.parse(localStorage.getItem("user")).token;
            const requestOptions = {
                method: 'GET',
                headers: { 'Content-Type': 'application/json' ,
                        "Authorization" : `Bearer ${token}` } ,
                
            };
        
            const response =  await fetch("http://localhost:8081/api/medicamentos/"+id, requestOptions);
            const data = await response.json();
            

            return data;
            
        
        }
    