
export const login = async (datos) =>{

    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(datos)
    };

    const response =  await fetch("http://localhost:8081/api/login", requestOptions);
    const data = await response.json();

    return data;

}