import React,{useEffect, useState} from "react";
import {
    useParams, useNavigate
} from "react-router-dom"; 
import {AxiosGet,AxiosPost} from "../utilities/Axios";

const BeamMeUp = () => {

    const {code} = useParams();
    
    React.useLayoutEffect(() => {
        AxiosGet(`/show/${code}`).then(
            res => {
                
                window.location = res.data.url;
            }
        )
        
    });
    return <div>{code}</div>
}

export default BeamMeUp;