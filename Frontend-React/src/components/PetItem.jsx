/**
 * Renders a single pet item.
 *
 * @param {Object} pet - The pet object to be rendered.
 * @return {JSX.Element} The rendered pet item.
 */
function PetItem({pet}) {
    return (
        <div>
        {pet.name} | {pet.type}
        </div>
    )
}
export default PetItem;