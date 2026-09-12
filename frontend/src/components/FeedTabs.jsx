

function FeedTabs({ selector, setSelector }) {
    return (
        <div className="top-container">
            <div className="top-item">
                <span
                    className={selector ? '' : 'marcador'}
                    onClick={() => setSelector(false)}
                >
                    <span>Para ti</span>
                </span>
            </div>

            <div className="top-item">
                <span
                    className={selector ? 'marcador' : ''}
                    onClick={() => setSelector(true)}
                >
                    <span>Siguiendo</span>
                </span>
            </div>
        </div>
    );
}

export default FeedTabs;