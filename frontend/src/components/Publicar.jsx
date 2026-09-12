import { use, useRef , useState } from 'react';

function Publicar({ user , onPublicado }) {

    const postInputRef = useRef(null);
    const [results, setResults] = useState([]);
    const [error, setError] = useState("");

    const publicar = async () => {
        const contenido = postInputRef.current.innerText;

        if (!contenido.trim()) {
            return;
        }

        try {
            const response = await fetch(
                'http://localhost:8080/api/posts',
                {
                    method: "POST",
                    credentials: "include",
                    headers: {
                         "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        body:contenido
                    })
                }
            );

            if(!response.ok){
                throw new Error('Error al publicar pio');
            }

            const data = await response.json();

            onPublicado(data);
            setResults(data);
            postInputRef.current.innerText = "";
            
        } catch (error){
            setError(error.message);
            setResults([]);
        }


        
    };

    return (
        <div className="publicar-container">
            <div className="publicar-top">
                <div className="avatar-container">
                    <img
                        src={`http://localhost:8080/uploads/avatars/${user.imgPerfil}`}
                        alt="avatar"
                    />
                </div>

                <div className="publicar-body">
                    <div
                        ref={postInputRef}
                        id="postInput"
                        className="publicar-input"
                        contentEditable="true"
                        data-placeholder="¿Qué te ha ofendido ahora?"
                        role="textbox"
                        aria-multiline="true"
                    />
                </div>
            </div>

            <div className="publicar-footer">
                <button onClick={publicar}>
                    Publicar
                </button>
            </div>
        </div>
    );
}

export default Publicar;