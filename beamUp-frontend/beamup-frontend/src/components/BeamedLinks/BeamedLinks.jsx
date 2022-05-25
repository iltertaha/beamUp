import React from 'react';
import styled from 'styled-components';
import { Arrow90degRight } from 'styled-icons/bootstrap';
import UfoImage from "./ufo.png";
import {Axios, AxiosGet, AxiosPost} from "../utilities/Axios"

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const BeamedLinks = () => {

    const[text, setText] = React.useState("");
    const[url,setUrl] = React.useState("");
    const[modal,setModalState] = React.useState(false);



    const [data, setData] = React.useState({
        message:"Data loaded",
        status:false
    });

    const linkSendHandler = () => {
        AxiosPost("/",{
            url: text
        }).then(
            res => {
                setUrl(res.data.code);
                toast(`This is your beamed code: ${res.data.code}`);
                console.log();
            }
        )

    }

    const linkGetterHandler = () => {
        console.log(url)
    }
    

    return (
        <PaddingBlock style={{flex:1}}>
            <ToastContainer />
            <div>
                    <div>
                        <h1>BeamUp Urls</h1>
                        <pre>Shorten links at lightning speed. <Arrow90degRight/></pre>
                    
                        <CustomInput>
                            <input type="text" placeholder="Type URL" onChange={(e) => {
                            setText(e.currentTarget.value)
                        }}/>
                        </CustomInput>
                        <Button onClick={linkSendHandler}> Beam me up, Scotty</Button>
                    </div>
                   
            </div>
            <RightBlock>
                <img src={UfoImage} alt="" />
            </RightBlock>

        </PaddingBlock>
        
    )
}

const RightBlock = styled.div`
flex:0.6;
padding-right:20px;
display:flex;
flex-direction:column;
align-items:center;
justify-content:center;
img{
    padding-left:200px;
    padding-bottom:80px;
    width:100%;
    transform:scale(1.5);
    object-fit:contain;
}
`

const CustomInput = styled.div`
    background: white;
    padding:20px 20px;
    width:500px;
    border-radius:180px;
    input{
        font-size:20px;
        width:100%;
        border:none;
        outline:none;
        background:transparent;
    }
`

const Button = styled.button`
    border:none;
    outline:none;
    background:var(--primary);
    width:540px;
    display:flex;
    align-items:center;
    justify-content:center;
    padding:20px;
    border-radius:180px;
    margin-top:40px;
    color:white;
    font-size:20px;`

const PaddingBlock = styled.div`
    padding-left:100px;
    padding-right:100px;
    padding-top:100px;
    display:flex;
    h1{
        
        color:white;
    }
    pre{
        color: white;
        font-size: 20px;
        position:relative;
        width:500px;
        height:100px;
        white-soace:pre-wrap;
        svg{
            // position:absolute;
            // bottom:0;
            // right:0;
            margin-top: 20px;
            width:30px;
            margin-left:10px;
            transform:rotate(90deg);
        }

    }

`

export default BeamedLinks;