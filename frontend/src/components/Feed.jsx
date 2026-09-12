import Pio from '../components/Pio.jsx'
import FeedTabs from './FeedTabs.jsx';
import Publicar from './Publicar.jsx';
import "../styles/feed.css"
import { useAuth } from '../context/AuthContext.jsx';
import { useState , useEffect } from 'react';

function Feed(){

    const {user} = useAuth();
    const [selector, setSelector] = useState(true) 
    const [error, setError] = useState("");
    const [page, setPage] = useState(0);
    const [results,setResults] = useState([]);
    const [loading, setLoading] = useState(true);
   

    const piosApi = async (page) =>{
        
        try {
            const response = await fetch(
                `http://localhost:8080/api/posts/timeline?page=${encodeURIComponent(page)}`,
                {
                    method: "GET",
                    credentials: "include"
                }
            );
            if(!response.ok){
                throw new Error("error con el timeline");
            }
            
            const data = await response.json();

            setResults(data);
        } catch (error){
            setError(error.message);
            setResults("");
        } finally{
            setLoading(false);
        }
    }

    useEffect(()=>{
        piosApi(page);
    }, [page]);

    if(loading){
        return <p> Cargando feed... </p>
    }

    const añadirPost = (nuevoPost) => {
        setResults(prev => [nuevoPost, ...prev]);
    };
    return (
        <> 
            <FeedTabs 
                selector={selector}
                setSelector={setSelector}
            />
            <Publicar 
                user={user}
                onPublicado={añadirPost}
            />
                
            {results.map((pio) => (
                <Pio 
                    key={pio.id}
                    nick = {pio.userNick}
                    user = {pio.userName}
                    time = {pio.createAt}
                    text = {pio.body}
                    //comments = {pio.comments}
                    repios = {pio.repostCount}
                    likes = {pio.likeCount}
                    views = {pio.views}
                    profileImgUrl = {pio.userImgPerfil}
                />
            ))}    
        </>
    )
    
}

export default Feed