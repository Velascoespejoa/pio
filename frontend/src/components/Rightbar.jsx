import '../styles/rightbar.css'

function Rightbar(){

    return (
        <>
            <div className="rightbar-container">
                <label className="search">
                    <svg
                        width="20"
                        height="20"
                        viewBox="0 0 24 24"
                        fill="none"
                    >
                        <circle
                            cx="11"
                            cy="11"
                            r="7"
                            stroke="currentColor"
                            strokeWidth="2"
                        />
                        <path
                            d="M16 16L21 21"
                            stroke="currentColor"
                            strokeWidth="2"
                            strokeLinecap="round"
                        />
                    </svg>

                    <input type="text" placeholder="Buscar"/>
                </label>

                <div className="tendencias">
                    <div className="tendencias-title">
                        <span>Tendencias</span>
                    </div>
                </div>
            </div>
        </>
    )
    
}

export default Rightbar