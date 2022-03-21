package kz.garage.multimedia.store.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Audio constructor(
    override val id: Long,
    override val uri: Uri,
    override val title: String?,
    override val displayName: String?,
    override val folder: Folder?,
    override val history: History?,
    override val duration: Long,
    override val properties: Properties?,
    val album: Album?,
    override val localFile: LocalFile?,
    override val remoteAddress: RemoteAddress?
) : Media(
    id = id,
    uri = uri,
    title = title,
    displayName = displayName,
    folder = folder,
    history = history,
    properties = properties,
    localFile = localFile,
    remoteAddress = remoteAddress
), Media.Playable, Parcelable {

    @Parcelize
    data class Album constructor(
        val id: Long,
        val title: String?,
        val artist: String?
    ) : Parcelable

}