export const getRecetasByUsername = async () =>{
    
    const token = JSON.parse(localStorage.getItem("user")).token;
    const username = JSON.parse(localStorage.getItem("user")).username;
        
        const requestOptions = {
            method: 'GET',
            headers: { "Authorization" : `Bearer ${token}` },
        };
        
        const response = await fetch("http://localhost:8081/api/"+username+"/recetas", requestOptions);
        const data = await response.json();
        return data;

    
    
}


export const postReceta = async (receta) => {
    const token = JSON.parse(localStorage.getItem("user")).token;
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' ,
                    "Authorization" : `Bearer ${token}` } ,
            body: JSON.stringify(receta)
        };
    
        const response =  await fetch("http://localhost:8081/api/recetas", requestOptions);
        const data = await response.json();
    
        return data;
    
    }