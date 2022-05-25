import axios from 'axios';

export const Axios = axios.create({
    baseURL:"http://localhost:8080/",
    headers:{
        "Content-Type":"application/json"
    }
})

export const AxiosGet = (url, data) => Axios.get(url, data);
export const AxiosPost = (url, data) => Axios.post(url, data)

